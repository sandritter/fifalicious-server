package de.sandritter.fifalicious.server.service

import de.sandritter.fifalicious.server.domain.model.Player
import de.sandritter.fifalicious.server.domain.model.Stroke
import de.sandritter.fifalicious.server.domain.repository.PlayerRepository
import de.sandritter.fifalicious.server.domain.repository.StrokeRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service('strokeService')
@Transactional
@CompileStatic
class StrokeServiceImpl implements StrokeService {

    @Autowired
    private StrokeRepository repository

    @Autowired
    private PlayerRepository playerRepository

    @Override
    void addStrokeToPlayer(long playerReference) {
        Player player = playerRepository.findOne(playerReference)
        repository.save(new Stroke(isActive: true, createDate: new Date(), player: player))
    }
}
