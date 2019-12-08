package eObrazovanje.web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eObrazovanje.web.model.Korisnik;
import eObrazovanje.web.repository.KorisnikRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private KorisnikRepo korisnikRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepo.findByKorisnickoIme(username);
        if(korisnik == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(korisnik.getTipKorisnika()));
            return new User(korisnik.getKorisnickoIme(),korisnik.getLozinka(),grantedAuthorities);
        }
    }
}
