package com.sale.pointsale.domain.Users;

import com.sale.pointsale.domain.IdentityDocuments.IdentDocImpl;
import com.sale.pointsale.domain.IdentityDocuments.IdentityDocumentsInputDTO;
import com.sale.pointsale.domain.Roles.RoleServiceImpl;
import com.sale.pointsale.domain.Roles.RolesInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private IdentDocImpl identDoc;
    private RoleServiceImpl roleServiceImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, IdentDocImpl identDoc, RoleServiceImpl roleServiceImpl) {
        this.userRepository = userRepository;
        this.identDoc = identDoc;
        this.roleServiceImpl = roleServiceImpl;
    }

    @Override
    public UserInputDTO printUser(UserOutputDTO userOutputDTO) {
        // Mapear UserOutputDTO a Users
        Users user = modelMapper.map(userOutputDTO, Users.class);

        // Generar un id aleatorio para el usuario
        user.setId((int) Math.floor(Math.random() * 1000));

        // Obtener el documento de identidad y el rol por sus respectivos ids
        IdentityDocumentsInputDTO document = identDoc.getDocumentById(userOutputDTO.getIdTypeDocument());
        RolesInputDTO role = roleServiceImpl.getRoleById(userOutputDTO.getIdRole());

        // Mapear User a UserInputDTO
        UserInputDTO userInput = modelMapper.map(user, UserInputDTO.class);

        userInput.setSalary(BigDecimal.valueOf(0.0));

        // Asignar los datos faltantes al UserInputDTO
        userInput.setTypeDocument(document);
        userInput.setNumDocument(userOutputDTO.getNumDocument());
        userInput.setState(false);
        userInput.setTelephone(userOutputDTO.getTelephone() != null ? userOutputDTO.getTelephone() : null);
        userInput.setMobile(userOutputDTO.getMobile() != null ? userOutputDTO.getMobile() : null);
        userInput.setRole(role);
        userInput.setCreationDate(new Date(System.currentTimeMillis()));

        return userInput;
    }
}
