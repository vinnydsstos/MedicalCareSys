package com.csm.Dunimed.SalesModule.repository;

import com.csm.Dunimed.SalesModule.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    public Optional<Channel> findByType(String type);
}