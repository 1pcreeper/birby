import Container from "../../components/common/general/Container";
function Dashboard() {
    return (
        <>
            <Container>
                <div className="flex flex-wrap">
                    <table>
                        <thead>
                            <tr>
                                <th>
                                    Human Resource
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    Staff Manage
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </Container>
        </>
    )
}
export default Dashboard;