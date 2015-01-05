package me.cresterida.conf.repository;

import java.util.List;

import me.cresterida.conf.entity.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserDetailsCustom,String>
{
    public UserDetailsCustom findByUsername(String username);

}
