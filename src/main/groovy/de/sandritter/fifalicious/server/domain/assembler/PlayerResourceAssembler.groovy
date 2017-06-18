package de.sandritter.fifalicious.server.domain.assembler

import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.web.PlayerController
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class PlayerResourceAssembler extends ResourceAssemblerSupport<Player, PlayerResource> {

    PlayerResourceAssembler() {
        super(PlayerController, PlayerResource)
    }

    @Override
    PlayerResource toResource(Player player) {
        player.reference = player.playerId
        createResourceWithId(player.playerId, player)
    }

    @Override
    protected PlayerResource instantiateResource(Player player) {
        new PlayerResource(player)
    }

    static class PlayerResource extends Resource<Player> {
        PlayerResource(Player player) {
            super(player)
        }
    }
}
