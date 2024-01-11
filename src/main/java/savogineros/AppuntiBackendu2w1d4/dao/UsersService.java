package savogineros.AppuntiBackendu2w1d4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savogineros.AppuntiBackendu2w1d4.entities.User;
import savogineros.AppuntiBackendu2w1d4.exceptions.ItemNotFoundException;

import java.util.List;

@Service // Specializzazione di Component
@Slf4j // sarebbe una specie di logger, così ce lo dà in automatico Lombok, ma se disattivi i log dall' dall'application service non funzionerà
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;

    // METODI
    public void save(User user) {
        // Eventuale logica addizionale custom (controlli vari, aggiunta campi extra allo user ecc...)
        if (user.getName().length() < 2) {
            throw new RuntimeException("Il nome non può essere più corto di due caratteri!");
        }
        // Devo usare UsersDAO per salvare lo user sul DB, essendo UsersService un Component ed essendo UsersDAO
        // anch'esso un Component
        usersDAO.save(user);
        System.out.println("User salvato correttamente!");
        //log.info("User salvato correttamente");  // se disattivi dall'application service i log non funzionerà neanche questo
    }

    public User findById(long id) {
        if (usersDAO.findById(id).isPresent()) {
            return usersDAO.findById(id).get();
            // usersDAO.findById(id) torna un tipo optional, perché può essere null o User, quindi devo gestire l'eccezione
            // se gestita e assicurato che esista posso fare il get()
            // se abbiamo la certezza che userOptional non sia null, con get restituiamo l'oggetto

        } else {
            throw new ItemNotFoundException(id);
            // Mi sono fatto una classe a parte per gestire questo tipo di eccezione, ma puoi tranquillamente fare:
            //throw new RuntimeException("User non presente");
        }

        // OPPURE la versione per PRO :
        // return usersDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<User> findAll() {
        return usersDAO.findAll();
    }







}
