package me.cresterida.conf.repository;

import me.cresterida.conf.entity.ClientsDetailsCustom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDetailsRepository extends JpaRepository<ClientsDetailsCustom, String> {
}
