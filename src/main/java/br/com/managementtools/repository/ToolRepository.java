package br.com.managementtools.repository;

import br.com.managementtools.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ToolRepository extends JpaRepository<Tool, Integer> {

    Optional<Tool> findByTags(String tag);
}
