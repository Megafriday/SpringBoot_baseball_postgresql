package jp.aki.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.aki.baseball.domain.Player;

public interface PlayerDao extends JpaRepository<Player, Integer> {

}
