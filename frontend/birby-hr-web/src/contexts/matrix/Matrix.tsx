import StaffsEditRoute from "../../routes/StaffsEditRoute";
import StaffsViewRoute from "../../routes/StaffsViewRoute";
import AppRouter from "../../routes/router/AppRouter";

interface Matrix {
    appRouter: AppRouter;
    staffsViewRoute: StaffsViewRoute;
    staffsEditRoute: StaffsEditRoute;
}
export default Matrix;