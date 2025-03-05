import { createBrowserRouter, LoaderFunctionArgs, ActionFunctionArgs } from "react-router-dom";
import Staffs from "../../pages/staffs/Staffs.tsx";
import Layout from "../../components/layouts/Layout";
import DefaultInterceptor from "../../components/interceptors/DefaultInterceptor";
import BasicSecurityInterceptor from "../../components/interceptors/BasicSecurityInterceptor";
import Dashboard from "../../pages/dashboard/Dashboard.tsx";
import StaffsViewRoute from "../StaffsViewRoute.tsx";
import StaffsView from "../../pages/staffs/view/StaffsView.tsx";
import StaffsEdit from "../../pages/staffs/edit/StaffsEdit.tsx";
import StaffsEditRoute from "../StaffsEditRoute.tsx";
import StaffsCreate from "../../pages/staffs/create/StaffsCreate.tsx";
import StaffsCreateRoute from "../StaffsCreateRoute.tsx";
import SickLeave from "../../pages/sick-leave/SickLeave.tsx"
import SickLeaveCreate from "../../pages/sick-leave/create/SickLeaveCreate.tsx";
import SickLeaveEdit from "../../pages/sick-leave/edit/SickLeaveEdit.tsx";
import Shift from "../../pages/shift/Shift.tsx";
import Attendance from "../../pages/attendance/Attendance.tsx";

class AppRouter {
    private readonly staffsViewRoute: StaffsViewRoute;
    private readonly staffsEditRoute: StaffsEditRoute;
    private readonly staffsCreateRoute: StaffsCreateRoute;
    constructor(
        staffsViewRoute: StaffsViewRoute,
        staffsEditRoute: StaffsEditRoute,
        staffsCreateRoute: StaffsCreateRoute
    ) {
        this.staffsViewRoute = staffsViewRoute;
        this.staffsEditRoute = staffsEditRoute;
        this.staffsCreateRoute = staffsCreateRoute;
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
                                    return await this.staffsViewRoute.loader({ params } as LoaderFunctionArgs<unknown>);
                                }
                            },
                            {
                                path: "/staffs/edit/:id",
                                element: <StaffsEdit />,
                                loader: async ({ params }: LoaderFunctionArgs<unknown>) => {
                                    return await this.staffsEditRoute.loader({ params } as LoaderFunctionArgs<unknown>);
                                },
                                action: async ({ request, params }: ActionFunctionArgs) => {
                                    return await this.staffsEditRoute.action({ request, params } as ActionFunctionArgs);
                                }
                            },
                            {
                                path: "/staffs/create",
                                element: <StaffsCreate />,
                                action: async ({ request, params }: ActionFunctionArgs) => {
                                    return await this.staffsCreateRoute.action({ request, params } as ActionFunctionArgs);
                                }
                            },
                            {
                                path: "/sick-leave",
                                element: <SickLeave />
                            },
                            {
                                path: "/sick-leave/edit",
                                element: <SickLeaveEdit />
                            },
                            {
                                path: "/sick-leave/create",
                                element: <SickLeaveCreate />
                            },
                            {
                                path: "/shift",
                                element: <Shift />
                            },
                            {
                                path: "/attendance",
                                element: <Attendance />
                            }
                        ]
                    }
                ]
            }
        ] as const);
    };

}
export default AppRouter;