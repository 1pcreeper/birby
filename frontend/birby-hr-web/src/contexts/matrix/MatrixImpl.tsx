import StaffsViewRoute from "../../routes/StaffsViewRoute";
import AppRouter from "../../routes/router/AppRouter";
import Matrix from "./Matrix";

class MatrixImpl implements Matrix {
    public readonly appRouter: AppRouter;
    public readonly staffsViewRoute: StaffsViewRoute;
    constructor() {
        this.staffsViewRoute = new StaffsViewRoute();

        this.appRouter = new AppRouter(this.staffsViewRoute);
    }
}
export default MatrixImpl;