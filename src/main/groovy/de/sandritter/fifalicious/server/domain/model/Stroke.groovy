package de.sandritter.fifalicious.server.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity
@Table(name = 'stroke')
class Stroke {

    @Id
    @Column(name = 'stroke_id')
    @GeneratedValue
    Long strokeId

    @Column(name = 'create_date')
    Date createDate

    @Column(name = 'is_active')
    boolean isActive

    @Column(name = 'player_reference')
    @JsonIgnore
    @ManyToOne
    private Player player;
}
