package com.homebooking.home_services.services;

import com.homebooking.home_services.dto.EnterpriseDTO;
import com.homebooking.home_services.mappers.EnterpriseMapper;
import com.homebooking.home_services.models.Enterprise;
import com.homebooking.home_services.models.User;
import com.homebooking.home_services.repositories.EnterpriseRepository;
import com.homebooking.home_services.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final UserRepository userRepository;
    private final EnterpriseMapper enterpriseMapper;

    public EnterpriseDTO create(EnterpriseDTO dto) {
        User user = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        Enterprise enterprise = enterpriseMapper.toEntity(dto, user);
        return enterpriseMapper.toDTO(enterpriseRepository.save(enterprise));
    }

    public EnterpriseDTO getById(Long id) {
        return enterpriseRepository.findById(id)
                .map(enterpriseMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));
    }

    public List<EnterpriseDTO> getByOwnerId(Long ownerId) {
        return enterpriseRepository.findByUserId(ownerId).stream()
                .map(enterpriseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EnterpriseDTO> getBySiren(String siren) {
        return enterpriseRepository.findBySiren(siren).stream()
                .map(enterpriseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EnterpriseDTO> getAll() {
        return enterpriseRepository.findAll().stream()
                .map(enterpriseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EnterpriseDTO update(Long id, EnterpriseDTO dto) {
        Enterprise existing = enterpriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setStatus(dto.getStatus());
        existing.setAddress(dto.getAddress());
        existing.setPhone(dto.getPhone());
        existing.setSiren(dto.getSiren());

        return enterpriseMapper.toDTO(enterpriseRepository.save(existing));
    }

    public void delete(Long id) {
        enterpriseRepository.deleteById(id);
    }

    public Long getOwnerId(Long enterpriseId) {
        Enterprise enterprise = enterpriseRepository.findById(enterpriseId)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));
        return enterprise.getUser().getId();
    }
}
