import StaffsCreateRoute from "../../routes/StaffsCreateRoute";
import StaffsEditRoute from "../../routes/StaffsEditRoute";
import StaffsViewRoute from "../../routes/StaffsViewRoute";
import AppRouter from "../../routes/router/AppRouter";
import Matrix from "./Matrix";

class MatrixImpl implements Matrix {
    public readonly appRouter: AppRouter;
    public readonly staffsViewRoute: StaffsViewRoute;
    public readonly staffsEditRoute: StaffsEditRoute;
    public readonly staffsCreateRoute: StaffsCreateRoute;
    constructor() {
        this.staffsViewRoute = new StaffsViewRoute();
        this.staffsEditRoute = new StaffsEditRoute();
        this.staffsCreateRoute = new StaffsCreateRoute();

        this.appRouter = new AppRouter(
            this.staffsViewRoute,
            this.staffsEditRoute,
            this.staffsCreateRoute
        );
    }
}
export default MatrixImpl;