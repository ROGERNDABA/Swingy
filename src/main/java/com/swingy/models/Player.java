package com.swingy.models;

import com.swingy.controls.MysqlConnect;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Player
 */
public class Player {
	private int id;
	private String heroName;
	private String heroClass;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hitPoints;
	protected Position position;

	private static int idCounter = 0;
	static MysqlConnect conn = MysqlConnect.getDbCon();

	public Player(String name, String heroClass) {
		this.id = nextId();
		this.level = 1;
		// this.experience = ;
		// this.attack = ;
		// this.defense = ;
		// this.hitPoints = ;
		this.position = new Position(this.level);

	}

	public Player(int _id) {
		this.id = _id;
		try {
			conn.query("SELECT * FROM Players WHERE ID = " + _id);
			ResultSet rSet = conn.query("SELECT * FROM Players");
			if (rSet.next() != false) {
				this.heroName = rSet.getString("Name");
				this.heroClass = rSet.getString("Class");
				this.level = rSet.getInt("Level");
				this.experience = rSet.getInt("Expirience");
				this.attack = rSet.getInt("Attack");
				this.defense = rSet.getInt("Defense");
				this.hitPoints = rSet.getInt("HitPoints");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getHeroName() {
		return this.heroName;
	}

	public int getId() {
		return this.id;
	}

	public String getHeroClass() {
		return this.heroClass;
	}

	public int getLevel() {
		return this.level;
	}

	public int getExperience() {
		return this.experience;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
		try {
			conn.insert("UPDATE Players SET Name = '" + heroName + "' WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
		try {
			conn.insert("UPDATE Players SET Class = '" + heroClass + "' WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setLevel(int level) {
		this.level = level;
		try {
			conn.insert("UPDATE Players SET Level = " + level + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setExperience(int experience) {
		this.experience = experience;
		try {
			conn.insert("UPDATE Players SET Expirience = " + experience + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setAttack(int attack) {
		this.attack = attack;
		try {
			conn.insert("UPDATE Players SET Attack = " + attack + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDefense(int defense) {
		this.defense = defense;
		try {
			conn.insert("UPDATE Players SET Defense = " + defense + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		try {
			conn.insert("UPDATE Players SET HitPoints = " + hitPoints + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int nextId() {
		return ++idCounter;
	}
}
