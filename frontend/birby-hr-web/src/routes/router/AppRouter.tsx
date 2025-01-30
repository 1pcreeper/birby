import { createBrowserRouter, LoaderFunctionArgs } from "react-router-dom";
import Staffs from "../../pages/staffs/Staffs";
import Layout from "../../components/layouts/Layout";
import DefaultInterceptor from "../../components/interceptors/DefaultInterceptor";
import BasicSecurityInterceptor from "../../components/interceptors/BasicSecurityInterceptor";
import Dashboard from "../../pages/dashboard/Dashboard";
import StaffsEditRoute from "../StaffsEditRoute";
import StaffsEdit from "../../pages/staffs/edit/StaffsEdit";

class AppRouter {
    private readonly staffsEditRoute: StaffsEditRoute;
    constructor(
        staffsEditRoute: StaffsEditRoute
    ) {
        this.staffsEditRoute = staffsEditRoute;
    }
    public createRouter(): ReturnType<typeof createBrowserRouter> {
        return createBrowserRouter([
            {
                path: "/",
                element: <Layout />,
                children: [
                    {
                        path: "/",
                        element: <DefaultInterceptor />,
                        children: [
                        ]
                    }
                    , {
                        path: "/",
                        element: <BasicSecurityInterceptor />,
                        children: [
                            {
                                path: "/dashboard",
                                element: <Dashboard />
                            },
                            {
                                path: "/staffs",
                                element: <Staffs />
                            },
                            {
                                path: "/staffs/edit/:id",
                                element: <StaffsEdit />,
                                loader: async ({ params }: LoaderFunctionArgs<unknown>) => {
                                    return await this.staffsEditRoute.loader(params);
                                }
                            }
                        ]
                    }
                ]
            }
        ] as const);
    };

}
export default AppRouter;