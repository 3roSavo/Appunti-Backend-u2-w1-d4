package savogineros.AppuntiBackendu2w1d4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savogineros.AppuntiBackendu2w1d4.entities.User;
@Repository // Specializzazione di @Component dedicata alle interazioni col DB
public interface UsersDAO extends JpaRepository<User,Long> {
    // Le interfacce tra di loro si ESTENDONO! Come una classe concreta estende da una astratta!
    // Estendendo JpaRepository eredito tutti i metodi CRUD, poi posso anche decidere di aggiungerne di altri
    // Cioè i metodi derivati oppure quelli personalizzati
    // Mi basta specificare nelle parentesi angolari <Classe dell'entità, Tipo della Primary Key (PK) long in questo caso>

}
