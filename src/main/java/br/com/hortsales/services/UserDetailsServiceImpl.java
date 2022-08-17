package br.com.hortsales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.repositories.PessoaRepository;
import br.com.hortsales.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private PessoaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByEmail(email);
		if(user.isPresent()) {
			return new UserSS(
					user.get().getId(), 
					user.get().getEmail(), 
					user.get().getSenha(), 
					user.get().getPerfils());
		}
		throw new UsernameNotFoundException(email);
	}
}
