import { Link } from "react-router-dom";
import Container from "../../components/common/general/Container";
function Staffs() {
    return (
        <>
            <Container>
                <div className="mb-10">
                    <h1 className="text-5xl font-medium">
                        Staff Management
                    </h1>
                </div>
                <div className="flex justify-around rounded-2xl border-2 mb-5">
                    <input type="text" className="w-full py-2" />
                    <button className="text-white border-l-2 px-5 rounded-r-2xl dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                        Search
                    </button>
                </div>
                <div className="overflow-x-auto border-3">
                    <table className="w-full">
                        <thead className="sm:text-2xl text-lg">
                            <tr className="border-b-3">
                                <th className="text-start ps-4">
                                    Staff Name
                                </th>
                                <th>
                                    No.
                                </th>
                                <th>
                                    Department
                                </th>
                                <th>
                                    Position
                                </th>
                                <th>
                                    Control
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr className="border-b-3 sm:text-2xl text-center">
                                <td className="text-start ps-4">Lin Chi Kin</td>
                                <td>A1234</td>
                                <td>IT</td>
                                <td>IT Admin</td>
                                <td>
                                    <Link to="/staffs/edit/1212" className="text-white bg-blue-400 px-4 rounded-xl">
                                        Edit
                                    </Link>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </Container>
        </>
    );
}
export default Staffs;