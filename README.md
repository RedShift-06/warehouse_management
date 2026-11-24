# Warehouse Management Platform

Stock management platform for a 3PL warehouse: clients, products, warehouse layout, trucks and appointments, reception, stock with lots and FEFO, exit requests, billing and dashboard.

**Stack:** Spring Boot + Java 21, PostgreSQL, Spring Security + JWT, JPA, Flyway, Swagger, Angular, Docker.

## Run the project

Requirements: Java 21, Docker.

```bash
# 1. Start the database
docker compose up -d

# 2. Start the backend
./mvnw spring-boot:run
```

3. Swagger UI: http://localhost:8080/swagger-ui.html

On Windows use `mvnw.cmd spring-boot:run` if `./mvnw` does not work.

## Team workflow (Git)

Never push directly to `develop` or `main`. Each person works on their own branch and opens a pull request.

### First time

```bash
git clone https://github.com/RedShift-06/warehouse_management.git
cd warehouse_management
git checkout develop
git checkout -b feature/task-2-master-data     # your own branch
```

### Daily work

```bash
git pull origin develop        # get the latest changes before you start
# ...work...
git add .
git commit -m "Add client CRUD"
git push -u origin feature/task-2-master-data
```

Then open a pull request into `develop` on GitHub and ask a teammate to review it.

### Branch names

| Task | Branch |
|------|--------|
| 1 Auth, users, roles, setup | `feature/task-1-auth` |
| 2 Clients, products, warehouse, import | `feature/task-2-master-data` |
| 3 Trucks, docks, appointments, reception | `feature/task-3-inbound` |
| 4 Stock, lots, FEFO, inventory | `feature/task-4-stock` |
| 5 Outbound, billing, dashboard | `feature/task-5-outbound-billing` |

### Rules

- Commit messages are short and start with a verb: `Add`, `Fix`, `Update`.
- Pull `develop` often to avoid big merge conflicts.
- Do not commit `.env`, passwords or secrets.
- Database changes go in a new Flyway migration in `src/main/resources/db/migration/`. Never edit a migration that is already merged.

## Project structure

```
com.project.warehouse
├── common/     shared code (BaseEntity, config, exceptions)
├── auth/       users, roles, JWT              (task 1)
├── master/     clients, products, warehouse   (task 2)
├── inbound/    docks, appointments, reception (task 3)
├── stock/      lots, pallets, FEFO, inventory (task 4)
├── outbound/   exit requests, picking         (task 5)
├── billing/    tariffs, invoices, payments    (task 5)
└── dashboard/  alerts and KPIs                (task 5)
```
