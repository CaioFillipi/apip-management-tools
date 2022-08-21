package br.com.managementtools.service;

import br.com.managementtools.model.Tool;
import br.com.managementtools.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository repositoryTool;

    public List<Tool> findAllTools(){
        return repositoryTool.findAll();
    }

    public Tool createNewTool(Tool tool){
        Tool newTool = repositoryTool.save(tool);
        return newTool;
    }
}
