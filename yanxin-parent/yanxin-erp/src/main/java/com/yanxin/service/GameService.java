package com.yanxin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanxin.dao.GameMapper;
import com.yanxin.domain.Game;
import com.yanxin.domain.GameExample;

@Service
public class GameService {

	@Autowired
	GameMapper gameDao;
	
	public List<Game> findListAllWithCategory(Map<String,Object> map){
		return gameDao.findListAllWithCategory(map);
	}
	
	@Transactional
	public void insert(Game game) {
		  gameDao.insert(game);
	}
	@Transactional
	public int delete(String[] GameIds) {
		int resultDelete = 0;
		if (GameIds != null && GameIds.length > 0) {
			for(String GameId : GameIds) {
				gameDao.deleteByPrimaryKey(Integer.parseInt(GameId));
			}
		}
		resultDelete = 1;
		return resultDelete;
	}
	
	public Game findById(Long id) {
		return gameDao.selectByPrimaryKey(id.intValue());
	}
	@Transactional
	public void update(Game game) {
        try {
        	GameExample example = new GameExample();
        	
        	example.createCriteria().andIdEqualTo(game.getId());
        	
        	gameDao.updateByExample(game, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
