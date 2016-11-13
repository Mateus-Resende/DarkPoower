package core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.util.JSON;
import mappings.base.Hero;
import mappings.base.Player;

import java.net.UnknownHostException;

/**
 * Created by mresende on 13/11/16.
 */
public class Database {

    private DB db;

    public Database() {
        try {
            MongoClient client = new MongoClient("localhost", 27017);
            db = client.getDB("dark_poower");
            db.setWriteConcern(WriteConcern.SAFE);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public boolean savePlayer(Player p) {
        return this.saveObject(db.getCollection("players"), p);
    }

    public boolean saveHero(Hero h) {
        return this.saveObject(db.getCollection("heroes"), h);
    }

    public DBCursor find(String collectionName, DBObject query) {
        return db.getCollection(collectionName).find(query);
    }

    private boolean saveObject(DBCollection c, Object o) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            DBObject objectJson = (DBObject) JSON.parse(mapper.writeValueAsString(o));
            c.save(objectJson);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return false;
    }


}
