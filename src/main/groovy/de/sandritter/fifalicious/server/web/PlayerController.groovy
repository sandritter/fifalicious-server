package de.sandritter.fifalicious.server.web

import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.service.PlayerService
import groovy.json.JsonOutput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.MediaTypes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/players')
class PlayerController {

    private PlayerService playerService

    @Autowired
    PlayerController(PlayerService playerService) {
        this.playerService = playerService
    }

    @GetMapping(path = '/', produces = MediaTypes.HAL_JSON_VALUE)
    String getAllPlayers() {
        List<Player> players = playerService.findAll()
        JsonOutput.toJson(players)
    }
}
