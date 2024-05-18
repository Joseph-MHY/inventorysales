package com.sale.pointsale.domain.Roles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public RolesInputDTO saveRole(RolesOutputDTO roleOutputDTO) {
        Roles role = modelMapper.map(roleOutputDTO, Roles.class);
        role.setId(null);
        Roles savedRole = roleRepository.save(role);
        return modelMapper.map(savedRole, RolesInputDTO.class);
    }

    @Override
    public List<RolesInputDTO> getAllRoles() {
        List<Roles> roles = roleRepository.findAll();
        return roles.stream()
                .map(role -> modelMapper.map(role, RolesInputDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RolesInputDTO getRoleById(Integer id) {
        Roles role = roleRepository.findById(id).orElse(null);
        return modelMapper.map(role, RolesInputDTO.class);
    }
}
