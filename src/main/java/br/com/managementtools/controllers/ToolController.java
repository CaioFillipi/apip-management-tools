package br.com.managementtools.controllers;

import br.com.managementtools.model.Tool;
import br.com.managementtools.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping
    public ResponseEntity<List<Tool>> getAllTools(@RequestParam("tag") @Nullable String tag){
        if(tag != null){
            return ResponseEntity.ok(toolService.findAllTools()
                    .stream().filter(t -> t.getTags().contains(tag)).toList());
        }
        return ResponseEntity.ok(toolService.findAllTools());
    }

    @PostMapping
    public ResponseEntity<Tool> insertNewTool(@RequestBody Tool tool, UriComponentsBuilder uriBuilder){
        Tool toolCreated = toolService.createNewTool(tool);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(toolCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(toolCreated);
    }
}
