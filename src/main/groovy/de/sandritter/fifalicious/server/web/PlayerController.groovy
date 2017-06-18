package de.sandritter.fifalicious.server.web

import de.sandritter.fifalicious.server.domain.assembler.PlayerResourceAssembler
import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.service.PlayerService
import de.sandritter.fifalicious.server.service.StrokeService
import groovy.util.logging.Slf4j
import org.hibernate.HibernateException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.web.bind.annotation.*

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE

@Slf4j
@RestController
@ExposesResourceFor(Player)
class PlayerController {

    private PlayerService playerService
    private StrokeService strokeService

    @Autowired
    PlayerController(PlayerService playerService, StrokeService strokeService) {
        this.playerService = playerService
        this.strokeService = strokeService
    }

    @GetMapping(path = '/players', produces = HAL_JSON_VALUE)
    Resources<PlayerResourceAssembler.PlayerResource> getAllPlayers() {
        List<Player> players = playerService.findAll()
        PlayerResourceAssembler assembler = new PlayerResourceAssembler()
        new Resources<PlayerResourceAssembler.PlayerResource>(assembler.toResources(players))
    }

    @PostMapping(path = '/player/add-stroke')
    Resource<PlayerResourceAssembler.PlayerResource> addStrokeToPlayer(@RequestBody Map<String,String> payload) {
        long playerReference = Long.parseLong(payload.get('playerReference'))
        validatePlayer(playerReference)



    }

    @PutMapping(path = '/player/delete-all-strokes')
    Resource<PlayerResourceAssembler.PlayerResource> deleteAllStrokesOfPlayer(@RequestBody Map<String,String> payload) {

    }

    private void validatePlayer(long playerReference) {
        if(!playerService.findOne(playerReference)) {
            throw new HibernateException('bouuu wrong playerId')
        }
    }
}
