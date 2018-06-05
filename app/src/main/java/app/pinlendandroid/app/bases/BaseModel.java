package app.pinlendandroid.app.bases;

import app.pinlendandroid.utils.Utils;

/**
 * Created by tohuy on 9/25/17.
 */

public class BaseModel {

    public String toString() {
        return Utils.parseObjectToJson(this);
    }
}
