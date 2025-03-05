import Container from "../../components/common/general/Container";
import { Link } from "react-router-dom";
import TitleHeader from "../../components/common/general/TitleHeader";
function Dashboard() {
    return (
        <>
            <Container>
                <TitleHeader title="Dashboard" />
                <div className="flex flex-wrap">
                    <section title="Human Resource" className="border-4 border-b-blue-950 rounded-lg">
                        <table>
                            <thead>
                                <tr>
                                    <th className="border-b-4 border-b-blue-950 p-3 text-3xl">
                                        <h2>
                                            Human Resource
                                        </h2>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td className="text-2xl p-3">
                                        <Link to="/staffs">
                                            Staff Management
                                        </Link>
                                    </td>
                                </tr>
                                <tr>
                                    <td className="text-2xl p-3">
                                        <Link to="/shift">
                                            Shift Management
                                        </Link>
                                    </td>
                                </tr>
                                <tr>
                                    <td className="text-2xl p-3">
                                        <Link to="/attendance">
                                            Attendance Management
                                        </Link>
                                    </td>
                                </tr>
                                <tr>
                                    <td className="text-2xl p-3">
                                        <Link to="/sick-leave">
                                            Sick Leave
                                        </Link>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                </div>
            </Container>
        </>
    )
}
export default Dashboard;