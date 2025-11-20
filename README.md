Event Catalog API.
--
Small Spring Boot API to manage **Venues** and **Events**.  
The project is designed as a training exercise for clean architecture, DTOs, mappers and profiles (`mem` and `jpa`).

Currently the API is using the **`mem` profile** (in-memory repositories with lists).

-----------------------------------------------------------------------------

Technologies
--
- Java 21
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- H2 Database (for `jpa` profile)
- Bean Validation (`spring-boot-starter-validation`)
- Lombok
- springdoc-openapi (Swagger UI)
------------------------------------------------------------------------------
Project structure
--

Main package: `com.riwi.event_catalog`

- `config`
  - `OpenApiConfig` – Swagger/OpenAPI configuration.
- `controller`
  - `EventController` – REST endpoints for Events.
  - `VenueController` – REST endpoints for Venues.
- `dto`
  - `EventDTO`, `VenueDTO` – data transfer objects.
- `entity`
  - `EventEntity`, `VenueEntity` – domain entities.
- `exception`
  - `BadRequestException`, `NotFoundException`, `ApiExceptionHandler`.
- `mapper`
  - `EventMapper`, `VenueMapper` – map between Entity and DTO.
- `repository`
  - `core` – `EventGateway`, `VenueGateway` (ports).
  - `mem` – `InMemoryEventGateway`, `InMemoryVenueGateway` (in-memory adapters).
  - `jpa` – JPA repositories and gateways (for a future profile).
- `service`
  - `EventService`, `EventServiceImpl`
  - `VenueService`, `VenueServiceImpl`
- `startup`
  - `MemSeeds`, `JpaSeeds` – initial data for each profile.

------------------------------------------------------------------------------------------------
TEST SWAGGER
--
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/a28c6ab8-1c74-4690-9886-aae18888f7e4" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/47751c6a-d025-4179-a5cf-15ca99215729" />
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/9db0e1c6-d37f-4c66-b2b3-80c875296584" />






