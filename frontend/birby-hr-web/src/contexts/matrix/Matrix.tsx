import AppRouter from "./../../routes/router/AppRouter";
import MatrixType from "./MatrixType";

class Matrix implements MatrixType {
    public appRouter: AppRouter;
    constructor() {
        this.appRouter = new AppRouter();
    }
}
export default Matrix;