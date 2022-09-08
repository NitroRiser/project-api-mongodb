package org.jtech.projectapimongodb.services;

import java.util.List;

import org.jtech.projectapimongodb.domain.User;
import org.jtech.projectapimongodb.dto.UserDTO;
import org.jtech.projectapimongodb.repository.UserRepository;
import org.jtech.projectapimongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll(){
        return repo.findAll();
    }
    
    public User findById(String id) {
    	User user = repo.findById(id).orElse(null);
    	if (user == null) {
    		throw new ObjectNotFoundException("Objeto não encontrado");
    	}
    	return user;
    }

    public User insert(User obj) {
    	return repo.insert(obj);
    }
    
    public void delete(String id) {
    	findById(id);
    	repo.deleteById(id);
    }
    
    public User update(User obj) {
    	User user = repo.findById(obj.getId()).orElse(null);
    	updateData(user, obj);
    	return repo.save(user);
    }
    
    private void updateData(User user, User obj) {

    	user.setName(obj.getName());
    	user.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
    	return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
    
    
}