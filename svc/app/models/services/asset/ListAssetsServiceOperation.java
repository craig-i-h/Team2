package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.AssetEntity;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;
import java.util.List;

public class ListAssetsServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListAssetsServiceOperation.class);

    private AssetDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListAssetsServiceOperation(AssetDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<AssetEntity> assets = dao.list();

        return jsonHelper.toJson(assets);
    }
}
