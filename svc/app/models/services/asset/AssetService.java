package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import play.api.Logger;

import javax.inject.Inject;

public class AssetService extends Service
{
    private CreateAssetServiceOperation createAssetServiceOperation;

    private ListAssetsServiceOperation listAssetsServiceOperation;

    private UpdateAssetServiceOperation updateAssetServiceOperation;

    private DeleteAssetServiceOperation deleteAssetServiceOperation;

    private GetAssetServiceOperation getAssetServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public AssetService(UnavailableServiceOperation unavailableServiceOperation,
                                CreateAssetServiceOperation createAssetServiceOperation,
                                ListAssetsServiceOperation listAssetsServiceOperation,
                                UpdateAssetServiceOperation updateAssetServiceOperation,
                                DeleteAssetServiceOperation deleteAssetServiceOperation,
                                GetAssetServiceOperation getAssetServiceOperation,
                                JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.createAssetServiceOperation = createAssetServiceOperation;

        this.listAssetsServiceOperation = listAssetsServiceOperation;

        this.updateAssetServiceOperation = updateAssetServiceOperation;

        this.deleteAssetServiceOperation = deleteAssetServiceOperation;

        this.getAssetServiceOperation = getAssetServiceOperation;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listAssetsServiceOperation.execute(jsonHelper.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteAssetServiceOperation.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return getAssetServiceOperation.execute(identifier);
    }
}
