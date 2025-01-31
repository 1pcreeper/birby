import StaffsEditRoute from "../../routes/StaffsEditRoute";
import StaffsViewRoute from "../../routes/StaffsViewRoute";
import AppRouter from "../../routes/router/AppRouter";
import Matrix from "./Matrix";

class MatrixImpl implements Matrix {
    public readonly appRouter: AppRouter;
    public readonly staffsViewRoute: StaffsViewRoute;
    public readonly staffsEditRoute: StaffsEditRoute;
    constructor() {
        this.staffsViewRoute = new StaffsViewRoute();
        this.staffsEditRoute = new StaffsEditRoute();

        this.appRouter = new AppRouter(
            this.staffsViewRoute,
            this.staffsEditRoute
        );
    }
}
export default MatrixImpl;