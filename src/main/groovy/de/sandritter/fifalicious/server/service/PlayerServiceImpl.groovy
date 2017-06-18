package de.sandritter.fifalicious.server.service

import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.domain.repository.PlayerRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service('playerService')
@Transactional
@CompileStatic
class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository

    @Override
    List<Player> findAll() {
        repository.findAll().toList()
    }

    @Override
    Player findOne(long playerReference) {
        repository.findOne(playerReference)
    }
}
