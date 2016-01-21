package controllers.resource.play;

import models.services.asset.AssetService;
import play.Logger;

import javax.inject.Inject;

public class AssetEndpoint extends ResourceEndpoint<AssetService>
{
    private static final Logger.ALogger logger = Logger.of(AssetEndpoint.class);

    @Inject public AssetEndpoint(AssetService assetService)
    {
        super(assetService);
    }
}
