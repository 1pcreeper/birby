import { Outlet } from "react-router-dom";

function BasicSecurityInterceptor() {
    return (
        <>
            <Outlet />
        </>
    );
}
export default BasicSecurityInterceptor;