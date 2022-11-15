package com.csm.MedicalCareSys.SalesModule.repository;

import com.csm.MedicalCareSys.SalesModule.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChannelRepository extends JpaRepository<Channel, UUID> {

    public Optional<Channel> findByType(String type);
}