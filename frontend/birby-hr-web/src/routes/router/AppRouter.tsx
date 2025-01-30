import { createBrowserRouter, IndexRouteObject } from "react-router-dom";
import Staffs from "../../pages/staffs/Staffs";

class AppRouter {
    public createRouter(): ReturnType<typeof createBrowserRouter> {
        return createBrowserRouter([
            {
                path: "/",
                element: <Staffs />
            },
            {
                path: "/staffs",
                element: <Staffs />
            }
        ] as IndexRouteObject[]);
    };

}
export default AppRouter;