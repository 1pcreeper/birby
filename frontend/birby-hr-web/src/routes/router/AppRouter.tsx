import { createBrowserRouter } from "react-router-dom";
import Staffs from "../../pages/staffs/Staffs";
import Layout from "../../components/layouts/Layout";
import DefaultInterceptor from "../../components/interceptors/DefaultInterceptor";
import BasicSecurityInterceptor from "../../components/interceptors/BasicSecurityInterceptor";
import Dashboard from "../../pages/dashboard/Dashboard";

class AppRouter {
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
                            }
                        ]
                    }
                ]
            }
        ] as const);
    };

}
export default AppRouter;