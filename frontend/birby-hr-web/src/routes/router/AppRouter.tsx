import { createBrowserRouter, LoaderFunctionArgs } from "react-router-dom";
import Staffs from "../../pages/staffs/Staffs";
import Layout from "../../components/layouts/Layout";
import DefaultInterceptor from "../../components/interceptors/DefaultInterceptor";
import BasicSecurityInterceptor from "../../components/interceptors/BasicSecurityInterceptor";
import Dashboard from "../../pages/dashboard/Dashboard";
import StaffsViewRoute from "../StaffsViewRoute.tsx";
import StaffsView from "../../pages/staffs/view/StaffsView.tsx";
import StaffsEdit from "../../pages/staffs/edit/StaffsEdit.tsx";

class AppRouter {
    private readonly staffsViewRoute: StaffsViewRoute;
    constructor(
        staffsViewRoute: StaffsViewRoute
    ) {
        this.staffsViewRoute = staffsViewRoute;
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
                                path: "/staffs/view/:id",
                                element: <StaffsView />,
                                loader: async ({ params }: LoaderFunctionArgs<unknown>) => {
                                    return await this.staffsViewRoute.loader(params);
                                }
                            },
                            {
                                path: "/staffs/edit/:id",
                                element: <StaffsEdit />,
                                loader: async ({ params }: LoaderFunctionArgs<unknown>) => {
                                    return await this.staffsViewRoute.loader(params);
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