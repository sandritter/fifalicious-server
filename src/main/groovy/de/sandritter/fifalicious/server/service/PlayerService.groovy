package de.sandritter.fifalicious.server.service

import de.sandritter.fifalicious.server.domain.model.Player

interface PlayerService {
    List<Player> findAll()
}