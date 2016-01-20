package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import org.mockito.Mockito;

public class AssetServiceTestBuilder
{
    private JsonNode mockJsonNode;


    private CreateAssetServiceOperation mockCreateAssetServiceOperation;
    private DeleteAssetServiceOperation mockDeleteAssetServiceOperation;
    private GetAssetServiceOperation mockGetAssetServiceOperation;
    private UpdateAssetServiceOperation mockUpdateAssetServiceOperation;
    private ListAssetsServiceOperation mockListAssetServiceOperation;

    public void createAssetServiceMockTest()
    {
        mockJsonNode = Mockito.mock(JsonNode.class);

        mockListAssetServiceOperation = Mockito.mock(ListAssetsServiceOperation.class);
        mockCreateAssetServiceOperation = Mockito.mock(CreateAssetServiceOperation.class);
        mockDeleteAssetServiceOperation = Mockito.mock(DeleteAssetServiceOperation.class);
        mockGetAssetServiceOperation = Mockito.mock(GetAssetServiceOperation.class);
        mockUpdateAssetServiceOperation = Mockito.mock(UpdateAssetServiceOperation.class);

        Mockito.when(mockListAssetServiceOperation.execute(new JSONHelper().toJson(""))).thenReturn(new JSONHelper().toJson(""));
        Mockito.when(mockUpdateAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockGetAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockDeleteAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockCreateAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
    }

    public JsonNode getMockJsonNode()
    {
        return mockJsonNode;
    }

    public UpdateAssetServiceOperation getMockUpdateAssetServiceOperation()
    {
        return mockUpdateAssetServiceOperation;
    }

    public ListAssetsServiceOperation getListAssetServiceOperation()
    {
        return mockListAssetServiceOperation;
    }

    public CreateAssetServiceOperation getMockCreateAssetServiceOperation()
    {
        return mockCreateAssetServiceOperation;
    }

    public GetAssetServiceOperation getMockGetAssetServiceOperation()
    {
        return mockGetAssetServiceOperation;
    }

    public DeleteAssetServiceOperation getMockDeleteAssetServiceOperation()
    {
        return mockDeleteAssetServiceOperation;
    }
}
