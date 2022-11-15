package com.csm.MedicalCareSys.SalesModule.repository;

import com.csm.MedicalCareSys.SalesModule.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    public Optional<Channel> findByType(String type);
}