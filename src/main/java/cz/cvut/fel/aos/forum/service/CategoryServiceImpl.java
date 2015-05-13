package cz.cvut.fel.aos.forum.service;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.entity.*;
import cz.cvut.fel.aos.forum.helpers.PersistenceTools;
import java.util.List;

public class CategoryServiceImpl extends AbstractDataAccessService implements CategoryService {

    @Override
    public List<CategoryDTO> getAll() {
        return PersistenceTools.getCategoryDtos(genericDao.getAll(Category.class));
    }

    @Override
    public List<CategoryDTO> find(String sort, String filter, int base, int offset) {
        if (sort == "") {
            sort = "e.id asc";
        } else {
            sort = "e." + sort.replace(":", " ");
        }
        return PersistenceTools.getCategoryDtos(genericDao.getPage(sort, filter, base, offset, Category.class));
    }

    @Override
    public CategoryDTO get(Long id) {
        return PersistenceTools.getCategoryDto(genericDao.getById(id, Category.class));
    }

    @Override
    public void delete(Long id) {
        genericDao.removeById(id, Category.class);
    }


    @Override
    public Long save(CategoryDTO dto) {
        Category entity = PersistenceTools.getCategoryEntity(dto);

        return genericDao.saveOrUpdate(entity).getId();
    }


    public Long getCount() {
        return genericDao.getCount(User.class);
    }

//    WebTarget resourceTarget = target.path("/" + id).path("/group").queryParam("findWho",findWho);
//    Invocation.Builder invocationBuilder = resourceTarget.request(MediaType.APPLICATION_JSON_TYPE);
//    Response response = invocationBuilder.get();
//    int status = response.getStatus();
//
//    if (logger.isDebugEnabled()) {
//        logger.debug("geGroups.status = " + status);
//    }
//
//    if (status == 200) {
//        List<VoterGroupDTO> voters = response.readEntity(new GenericType<List<VoterGroupDTO>>() {
//        });
//        response.close();
//        return voters;
//    } else {
//        return new ArrayList<VoterGroupDTO>();
//    }

//    private GPS getGps(String destination) {
//        Client client = Client.create();
//        WebResource webResource = client.resource("http://maps.googleapis.com/maps/api/geocode/json")
//                .queryParam("address", destination).queryParam("sensor", "false");
//        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
//        if (response.getStatus() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//        }
//
//        InputStream is = response.getEntityInputStream();
//        int ch;
//        StringBuilder sb = new StringBuilder();
//        try {
//            while((ch = is.read())!= -1)
//                sb.append((char)ch);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JsonParser parser = new JsonParser();
//        JsonElement element = parser.parse(sb.toString());
//        if (element.isJsonObject()) {
//
//            JsonObject location = element.getAsJsonObject()
//                    .get("results").getAsJsonArray()
//                    .get(0).getAsJsonObject()
//                    .get("geometry").getAsJsonObject().get("location").getAsJsonObject();
//            return new GPS(location.get("lat").getAsDouble(), location.get("lng").getAsDouble());
//        }
//        return null;
//    }

}
