package jp.aki.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.aki.baseball.domain.Player;
import jp.aki.baseball.repository.PlayerDao;

@Service
public class BaseBallService {

	@Autowired
	private PlayerDao playerdao;

	public void deleteById(Integer id) {
		playerdao.deleteById(id);
	}

	public List<Player> findAll() {
		return playerdao.findAll();
	}

	public Player findById(Integer id) {
		return playerdao.findById(id).orElse(new Player());
	}

	public Player save(Player player) {
		return playerdao.save(player);
	}

}
