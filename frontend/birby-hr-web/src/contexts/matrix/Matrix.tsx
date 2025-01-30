import StaffsEditRoute from "../../routes/StaffsEditRoute";
import AppRouter from "./../../routes/router/AppRouter";
import MatrixType from "./MatrixType";

class Matrix implements MatrixType {
    public readonly appRouter: AppRouter;
    public readonly staffsEditRoute: StaffsEditRoute;
    constructor() {
        this.staffsEditRoute = new StaffsEditRoute();

        this.appRouter = new AppRouter(this.staffsEditRoute);
    }
}
export default Matrix;