/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.services;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author facundoandresdominguez
 */
public interface MutantService {

    public boolean isMutant(JSONObject body) throws JSONException,InterruptedException;

    public boolean isMutantAsync(JSONObject body) throws JSONException;

    public boolean validateDNA(JSONObject body) throws JSONException;

}
