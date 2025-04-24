package com.homebooking.home_services.controllers;

import com.homebooking.home_services.dto.EnterpriseDTO;
import com.homebooking.home_services.services.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
@RequiredArgsConstructor
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    @PostMapping
    public ResponseEntity<EnterpriseDTO> create(@RequestBody EnterpriseDTO dto) {
        return ResponseEntity.ok(enterpriseService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enterpriseService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnterpriseDTO>> getAll() {
        return ResponseEntity.ok(enterpriseService.getAll());
    }

    @GetMapping("/owner/{ownerId}") // Endpoint pour obtenir les entreprises par ID de propriétaire
    public ResponseEntity<List<EnterpriseDTO>> getByOwnerId(@PathVariable Long ownerId) {
        return ResponseEntity.ok(enterpriseService.getByOwnerId(ownerId));
    }

    @GetMapping("/siren/{siren}")
    public ResponseEntity<List<EnterpriseDTO>> getBySiren(@PathVariable String siren) {
        return ResponseEntity.ok(enterpriseService.getBySiren(siren));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> update(@PathVariable Long id, @RequestBody EnterpriseDTO dto) {
        return ResponseEntity.ok(enterpriseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enterpriseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/owner") // Endpoint pour obtenir l'ID du propriétaire
    public ResponseEntity<Long> getOwner(@PathVariable Long id) {
        return ResponseEntity.ok(enterpriseService.getOwnerId(id));
    }
}
