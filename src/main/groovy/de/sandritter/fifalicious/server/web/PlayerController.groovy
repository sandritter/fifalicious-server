package de.sandritter.fifalicious.server.web

import de.sandritter.fifalicious.server.domain.assembler.PlayerResourceAssembler
import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.service.PlayerService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.Resources
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE

@Slf4j
@RestController
@ExposesResourceFor(Player)
class PlayerController {

    private PlayerService playerService

    @Autowired
    PlayerController(PlayerService playerService) {
        this.playerService = playerService
    }

    @GetMapping(path = '/players', produces = HAL_JSON_VALUE)
    Resources<PlayerResourceAssembler.PlayerResource> getAllPlayers() {
        List<Player> players = playerService.findAll()
        PlayerResourceAssembler assembler = new PlayerResourceAssembler()
        new Resources<PlayerResourceAssembler.PlayerResource>(assembler.toResources(players))
    }
}
